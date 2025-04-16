package commands;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class Info extends ListenerAdapter {
  public CommandData getCommandData() {
    return Commands.slash("info", "Returns bot info");
  }

  @Override
  public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
    if(event.getName().equals("info")) {
      String botName = event.getJDA().getSelfUser().getName();
      String botId = event.getJDA().getSelfUser().getId();
      String botVersion = "1.0.0"; // Replace with actual version if available
      String botStatus = event.getJDA().getStatus().toString();

      EmbedBuilder embed = new EmbedBuilder()
        .setTitle("**Bot Information** \n")
        .setDescription("Bot Name: " + botName + "\n" +
                        "Bot ID:" + botId + "\n" +
                       "Version: " + botVersion + "\n" +
                       "Status: " + botStatus +"\n")
        .setFooter("Made by sealeopard | " + botId)
        .setColor(Color.orange);

        event.replyEmbeds(embed.build()).queue();
        embed.clear();
    }
  }

}