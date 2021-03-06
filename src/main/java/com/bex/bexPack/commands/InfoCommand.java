package com.bex.bexPack.commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import com.bex.bexPack.main.PixelCandy;
import com.bex.bexPack.util.Messenger;

public class InfoCommand 
{
	private CommandSpec commandSpec = CommandSpec.builder()
			.description(Text.of("Get version info"))
			.permission("bex.dev")
			.executor(new CommandExecutor() {

				@Override
				public CommandResult execute(CommandSource src, CommandContext args) throws CommandException 
				{
					if(src instanceof Player)
					{
						Player p = (Player)src;
						if(p.getUniqueId()==PixelCandy.bex||src.hasPermission("bex.dev"))
						{

							Messenger.sendMessage(src, ":"+PixelCandy.VERSION, TextColors.GREEN);
							//Text msg = Text.builder(Getters.getPrefix().toString())
							//		.append(Text.builder(ver).color(TextColors.GREEN)
							//				.build()).build();
							//p.sendMessage(msg);
							return CommandResult.success();
						}
					}
					else
					{
						Messenger.sendMessage(src, ":"+PixelCandy.VERSION, TextColors.GREEN);
						//src.sendMessage(Text.of(Getters.getPrefix()+":"+PixelCandy.VERSION));
					}
					return CommandResult.success();
				}
			})
			.build();

	public CommandSpec getCommandSpec() {
		return commandSpec;
	}	

}
