package com.denisindenbom.discordauth.discord;

import com.denisindenbom.discordauth.DiscordAuth;
import com.denisindenbom.discordauth.units.Account;
import com.denisindenbom.discordauth.units.LoginConfirmationRequest;
import com.denisindenbom.discordauth.utils.MessageSender;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.TimeUnit;

public class LoginConfirmationHandler extends ListenerAdapter
{
    private final DiscordAuth plugin;
    private final FileConfiguration messagesConfig;
    private final MessageSender messageSender = new MessageSender();

    public LoginConfirmationHandler(DiscordAuth plugin)
    {
        this.plugin = plugin;
        this.messagesConfig = plugin.getMessagesConfig();
    }

    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event)
    {
        // Tắt logic xử lý emoji
        /*
        String messageId = event.getMessageId();
        if (event.getUser() == null) return;
        if (event.getChannelType() != ChannelType.PRIVATE || event.getUser().isBot()) return;

        if (Emoji.fromUnicode("U+2705").equals(event.getEmoji()))
        {
            LoginConfirmationRequest loginConfirmationRequest =
                    this.plugin.getLoginConfirmationRequestManager().getLoginConfirmationRequest(messageId);

            if (loginConfirmationRequest == null) return;

            String id = loginConfirmationRequest.getId();
            Account account = loginConfirmationRequest.getAccount();
            Player player = this.plugin.getServer().getPlayer(account.getName());

            this.plugin.getLoginConfirmationRequestManager().removeRequest(id);

            if (player == null)
            {
                this.plugin.getBot().sendError(this.messagesConfig.getString("bot_error.login"), event.getChannel());
                return;
            }

            this.plugin.getAuthManager().addAccount(account);

            this.plugin.getBot().sendSuccessful(this.messagesConfig.getString("bot.login"), event.getChannel());

            event.getChannel().deleteMessageById(messageId).queueAfter(15, TimeUnit.SECONDS);

            this.plugin.getLogger().info(player.getName() + " logged in!");

            this.messageSender.sendMessage(player, this.messagesConfig.getString("welcome"),"{%username%}", player.getName());
        }
        */
    }
}
