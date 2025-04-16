import javax.security.auth.login.LoginException;

import commands.Info;
import commands.Ping;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Bot extends ListenerAdapter {
    private static JDA jda;
    
    public static void main(String[] args) throws LoginException {
        Dotenv dotenv = Dotenv.load();
        String token = dotenv.get("BOT_TOKEN");

        // Create command instances
        Ping pingCommand = new Ping();
        Info infoCommand = new Info();

        JDABuilder builder = JDABuilder.createDefault(token)
            .setActivity(Activity.playing("Hello from Java!"))
            .addEventListeners(pingCommand)
            .addEventListeners(infoCommand);

        // Store JDA instance
        jda = builder.build();
        
        // Register the slash commands
        jda.updateCommands().addCommands(
            pingCommand.getCommandData(),
            infoCommand.getCommandData()
        ).queue();
    }
}
