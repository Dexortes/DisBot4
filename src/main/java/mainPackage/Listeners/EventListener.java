package mainPackage.Listeners;

import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.requests.GatewayIntent;


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
        String message = currentUser.getAsMention() + " you've been noticed!" + emoji + " in the channel " + channelMention;
        //event.getGuild().getDefaultChannel().sendMessage(message); //doesn't work

        event.getGuild().getTextChannelsByName("general", true).get(0).sendMessage(message).queue();


    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        if(message.contains("Study")){
            event.getChannel().sendMessage("Soup!").queue();
        }
    }
    
}
