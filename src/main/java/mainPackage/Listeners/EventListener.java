package mainPackage.Listeners;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.ArrayList;
import java.util.List;


public class EventListener extends ListenerAdapter {
    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        //Souper reaction is here! in #general
        User currentUser = event.getUser();
        String emoji = event.getReaction().getEmoji().getAsReactionCode();
        String channelMention = event.getChannel().getAsMention();
        Channel channel = event.getChannel();
        String jumpLink = event.getJumpUrl();
        assert currentUser != null;
        String message = currentUser.getAsMention() + " you've reacted with " + emoji + " in the channel " + channelMention;
        //event.getGuild().getDefaultChannel().sendMessage(message); //doesn't work
        event.getGuild().getTextChannelsByName("general", true).get(0).sendMessage(message).queue();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        if(message.contains("$tudy")){
            event.getChannel().sendMessage("$oup!").queue();
        }
    }

    @Override
    public void onGuildJoin(GuildJoinEvent event) {
        List<CommandData> commandsList = new ArrayList<>();
        commandsList.add(Commands.slash("greetings", "Get welcomed by the bot"));
        event.getGuild().updateCommands().addCommands(commandsList).queue();
    }

    @Override
    public void onGuildReady(GuildReadyEvent event) {
        List<CommandData> commandsList = new ArrayList<>();
        commandsList.add(Commands.slash("greetings", "Get welcomed by the bot"));
        event.getGuild().updateCommands().addCommands(commandsList).queue();

//        if(event.getGuild().getIdLong() == 988498396467851344L){ //spec commands for a certain guild
//
//        }
    }
}
