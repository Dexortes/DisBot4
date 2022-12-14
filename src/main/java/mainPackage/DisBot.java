package mainPackage;

import io.github.cdimascio.dotenv.Dotenv;
import mainPackage.Listeners.EventListener;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class DisBot {

    private final Dotenv config;
    private final ShardManager shardManager;

    public DisBot() throws LoginException{
        config = Dotenv.configure().load();
        String token = config.get("TOKEN");
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setActivity(Activity.playing("Study Soup World"))
        .setStatus(OnlineStatus.ONLINE)
        .enableIntents(GatewayIntent.MESSAGE_CONTENT)
        .enableIntents(GatewayIntent.GUILD_MEMBERS);
        shardManager = builder.build();

        shardManager.addEventListener(new EventListener());
    }

    public Dotenv getConfig(){
        return config;
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args) {
        try{
            DisBot bot = new DisBot();
        } catch (LoginException e) {
            System.out.println("ERROR: Token is invalid");
        }
    }
}

//comment for push-check