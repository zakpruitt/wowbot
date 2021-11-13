package com.zakpruitt.wowbot.Listeners.Implementations;

import com.vdurmont.emoji.EmojiParser;
import com.zakpruitt.wowbot.Listeners.DeleteReactionListener;
import org.javacord.api.entity.emoji.Emoji;
import org.javacord.api.event.message.reaction.ReactionAddEvent;
import org.springframework.stereotype.Component;

@Component
public class DeleteReactionListenerImplementation implements DeleteReactionListener {

    @Override
    public void onReactionAdd(ReactionAddEvent reactionAddEvent) {
        if (reactionAddEvent.getEmoji().equalsEmoji(EmojiParser.parseToUnicode(":thumbsup:"))) {
            reactionAddEvent.deleteMessage();
        }
    }
}
