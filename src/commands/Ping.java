package commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class Ping extends ListenerAdapter {
    
  public CommandData getCommandData() {
    return Commands.slash("ping", "Replies with pong!");
  }
  
  @Override
  public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
    if (event.getName().equals("ping")) {
      long gatewayPing = event.getJDA().getGatewayPing();
      event.reply("Pong! Gateway Ping: " + gatewayPing + "ms").queue();
    }
  }
}
