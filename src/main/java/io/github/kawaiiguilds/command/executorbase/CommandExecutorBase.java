/*
 * Copyright (C) 2013 Dabo Ross <http://www.daboross.net/>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.github.kawaiiguilds.command.executorbase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.kawaiiguilds.Messages;
import io.github.kawaiiguilds.util.MessageUtil;
import org.apache.commons.lang.Validate;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

public class CommandExecutorBase implements TabExecutor{

    private final Map<String, SubCommand> aliasToCommandMap = new HashMap<>();
    private final List<SubCommand> subCommands = new ArrayList<>();
    private final String commandPermission;

    public CommandExecutorBase(String commandPermission){
        this.commandPermission = commandPermission;
    }

    public final void addSubCommand(SubCommand subCommand){
        Validate.notNull(subCommand);
        subCommands.add(subCommand);
        aliasToCommandMap.put(subCommand.getName(), subCommand);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        SubCommand subCommand = getSubCommand(sender, label, args);
        if (subCommand != null) {
            String[] subCommandArgs = ArrayHelpers.getSubArray(args, 1, args.length - 1);
            if (checkFilters(sender, cmd, subCommand, label, args[0], subCommandArgs)) {
                subCommand.runCommand(sender, cmd, label, args[0], subCommandArgs);
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args){
        if (args.length == 0 || args[0].isEmpty()){
            ArrayList<String> resultList = new ArrayList<>();
            for (Map.Entry<String, SubCommand> entry : aliasToCommandMap.entrySet()) {
                if (hasHelpConditions(sender, entry.getValue())){
                    resultList.add(entry.getKey());
                }
            }
            return resultList;
        } else if (args.length == 1){
            ArrayList<String> resultList = new ArrayList<>();
            for (Map.Entry<String, SubCommand> entry : aliasToCommandMap.entrySet()){
                if (entry.getKey().startsWith(args[0].toLowerCase())){
                    if (hasHelpConditions(sender, entry.getValue())){
                        resultList.add(entry.getKey());
                    }
                }
            }
            return resultList;
        } else {
            SubCommand subCommand = aliasToCommandMap.get(args[0].toLowerCase());
            if (subCommand != null && hasHelpConditions(sender, subCommand)){
                return subCommand.tabComplete(sender, cmd, label, subCommand, args[0], ArrayHelpers.getSubArray(args, 1, args.length - 1));
            } else {
                return Collections.emptyList();
            }
        }
    }

    private void sendInvalidSubCommandMessage(CommandSender sender){
        MessageUtil.sendMessage(sender, Messages.COMMANDLIST);
    }

    private void sendHelpMessage(CommandSender sender) {
        MessageUtil.sendMessage(sender, Messages.COMMANDLIST);
    }

    private void sendNoPermissionMessage(CommandSender sender, String label){
        sender.sendMessage(Messages.NOPERMISSION);
    }

    private SubCommand getSubCommand(CommandSender sender, String label, String[] args){
        if (!hasPermission(sender)) {
            sendNoPermissionMessage(sender, label);
            return null;
        }
        if (args.length < 1) {
            sendHelpMessage(sender);
            return null;
        }
        SubCommand command = aliasToCommandMap.get(args[0].toLowerCase());
        if (command == null) {
            sendInvalidSubCommandMessage(sender);
            return null;
        }
        return command;
    }

    private boolean hasPermission(CommandSender sender) {
        return (commandPermission == null || sender.hasPermission(commandPermission) || !(sender instanceof Player));
    }

    static String getHelpMessage(SubCommand subCommand, String baseCommandLabel){
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append(baseCommandLabel).append(subCommand.getName());
        if (!subCommand.getArgumentNames().isEmpty()) {
            for (String argument : subCommand.getArgumentNames()) {
                resultBuilder.append("argumenty").append(argument);
            }
        }
        resultBuilder.append(subCommand.getHelpMessage());
        return resultBuilder.toString();
    }

    private static boolean hasHelpConditions(CommandSender sender, SubCommand subCommand){
        for (CommandPreCondition condition : subCommand.getHelpConditions()){
            if (!condition.canContinue(sender, subCommand)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkFilters(CommandSender sender, Command baseCommand, SubCommand subCommand, String baseCommandLabel, String subCommandLabel, String[] subCommandArgs){
        for (CommandFilter filter : subCommand.getCommandFilters()){
            if (!filter.canContinue(sender, baseCommand, subCommand, baseCommandLabel, subCommandLabel, subCommandArgs)){
                sender.sendMessage(filter.getDeniedMessage(sender, baseCommand, subCommand, baseCommandLabel, subCommandLabel, subCommandArgs));
                return false;
            }
        }
        return true;
    }
}
