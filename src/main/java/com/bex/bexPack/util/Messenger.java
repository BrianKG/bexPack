package com.bex.bexPack.util;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.text.LiteralText.Builder;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;



public class Messenger
{


	/**
	 * Construct a message and broadcast it to the server
	 * @param message message in full #[0-9,a-f] as color code
	 * @color_codes
	 * [#0 = black]
	 * [#1 = dark blue]
	 * [#2 = dark green]
	 * [#3 = dark aqua]
	 * [#4 = dark red]
	 * [#5 = dark purple]
	 * [#6 = gold]
	 * [#7 = gray]
	 * [#8 = dark gray]
	 * [#9 = blue]
	 * [#a = green]
	 * [#b = aqua]
	 * [#c = red]
	 * [#f = light purple]
	 * [#e = yellow]
	 * [#f = white]
	 */
	public static void broadcastMessage(String message)
	{
		Text msg = decodeString(message);
		Sponge.getServer().getBroadcastChannel().send(msg);
	}
	/**
	 * Construct a message and send it to the player
	 * @param src command source, usually a player
	 * @param message message in full #[0-9,a-f] as color code
	 * @color_codes
	 * [#0 = black]
	 * [#1 = dark blue]
	 * [#2 = dark green]
	 * [#3 = dark aqua]
	 * [#4 = dark red]
	 * [#5 = dark purple]
	 * [#6 = gold]
	 * [#7 = gray]
	 * [#8 = dark gray]
	 * [#9 = blue]
	 * [#a = green]
	 * [#b = aqua]
	 * [#c = red]
	 * [#f = light purple]
	 * [#e = yellow]
	 * [#f = white]
	 */
	public static void sendMessage(CommandSource src, String message)
	{
		Text msg = decodeString(message);
		src.sendMessage(msg);
	}
	/**
	 * Construct a 2 part message and send it to the player
	 * @param src = command source, usually a player
	 * @param message1 = first part of message, colored by color1 
	 * @param color1 = TextColors.<color>
	 * @param message2 = second part of message, colored by color2
	 * @param color2 = TextColors.<color>
	 */

	/**
	 * returns "You must be a player to run this command"
	 * @param src command source
	 */
	public static void sendMessageNotPlayer(CommandSource src)
	{
		Text msg = Text.builder("[pcan] ").color(TextColors.LIGHT_PURPLE).
				append(Text.builder("You must be a player to run this command").color(TextColors.RED).build()).build();
		src.sendMessage(msg);
	}
	
	//Create color split by #[hex]
	public static Text decodeString(String s)
	{
		String[] a = s.split("(?=#[a-f,0-1])");
		LinkedHashMap<String,TextColor> stringMap = new LinkedHashMap<String,TextColor>();

		for(String b:a)
		{
			stringMap.put(b,TextColors.WHITE);
			String bs = b.substring(0, 2);
			switch(bs)
			{
			case"#0":
				stringMap.put(b, TextColors.BLACK);
			case"#1":
				stringMap.put(b, TextColors.DARK_BLUE);
			case"#2":
				stringMap.put(b, TextColors.DARK_GREEN);
			case"#3":
				stringMap.put(b, TextColors.DARK_AQUA);
			case"#4":
				stringMap.put(b, TextColors.DARK_RED);
			case"#5":
				stringMap.put(b, TextColors.DARK_PURPLE);
			case"#6":
				stringMap.put(b, TextColors.GOLD);
			case"#7":
				stringMap.put(b, TextColors.GRAY);
			case"#8":
				stringMap.put(b, TextColors.DARK_GRAY);
			case"#9":
				stringMap.put(b, TextColors.BLUE);
			case"#a":
				stringMap.put(b, TextColors.GREEN);
			case"#b":
				stringMap.put(b, TextColors.AQUA);
			case"#c":
				stringMap.put(b, TextColors.RED);
			case"#d":
				stringMap.put(b, TextColors.LIGHT_PURPLE);
			case"#e":
				stringMap.put(b, TextColors.YELLOW);
			case"#f":
				stringMap.put(b, TextColors.WHITE);
			}
		}
		return rebuildString(stringMap);
	}
	//Create a colourized string
	public static Text rebuildString(LinkedHashMap<String,TextColor> stringMap)
	{
		Builder msg = Text.builder("[pcan] ").color(TextColors.LIGHT_PURPLE);
		for(String a :stringMap.keySet())
		{
			msg.append(Text.builder(a).color(stringMap.get(a)).build());
		}
		Text message = msg.build();
		return message;
	}


}
