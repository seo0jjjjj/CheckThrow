package me.rang.checkthrow.checkthrow;

import com.sun.tools.javac.comp.Check;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;


public class CheckThrowCommand implements CommandExecutor {
    private CheckThrow plugin;
    public CheckThrowCommand(CheckThrow checkThrow){
        this.plugin = checkThrow;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // "/qtoggle"
        Player player;
        NamespacedKey namespacedKey = new NamespacedKey(plugin,"isQtoggled");

        if(sender instanceof Player && args[0].length()==0){
            player = (Player) sender;
            PersistentDataContainer data = player.getPersistentDataContainer();
            String str = data.get(namespacedKey, PersistentDataType.STRING);
            boolean isQtoggled = (str==null) ? false : Boolean.parseBoolean(str); // 기본값 false
            //true 일 경우
            if(isQtoggled == true){
                isQtoggled = false;
                data.set(namespacedKey, PersistentDataType.STRING, new Boolean(isQtoggled).toString());
                player.sendMessage(ChatColor.WHITE+"Q 토글이 비활성화 되었습니다.");
            }
            // false 거나 null 일 경우
            else{
                isQtoggled = true;
                data.set(namespacedKey, PersistentDataType.STRING, new Boolean(isQtoggled).toString());
                player.sendMessage(ChatColor.WHITE+"Q 토글이 활성화 되었습니다.");
            }
        }
        return false;
    }
}