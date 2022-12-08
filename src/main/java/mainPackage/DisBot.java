package mainPackage;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class DisBot {

    private final ShardManager shardManager;

    public DisBot() throws LoginException{
        String token = "MTA0ODExNzE4MTMwMjQ1MjI3NA.GyLDRp.I3HW6CebD_UHmuUVBiXLe_mutm8aQ6MdXnGhMg";
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setActivity(Activity.playing("Study Soup World"))
        .setStatus(OnlineStatus.ONLINE);
        shardManager = builder.build();
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args) {
//        JDA bot = JDABuilder.createDefault("MTA0ODExNzE4MTMwMjQ1MjI3NA.GyLDRp.I3HW6CebD_UHmuUVBiXLe_mutm8aQ6MdXnGhMg")
//                .setActivity(Activity.playing("Study Soup World"))
//                .setStatus(OnlineStatus.ONLINE)
//                .build();
        try{
            DisBot bot = new DisBot();
        } catch (LoginException e) {
            System.out.println("ERROR: Token is invalid");
        }
    }
}
