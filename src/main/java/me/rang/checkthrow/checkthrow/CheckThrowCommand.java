package me.rang.checkthrow.checkthrow;

import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class CheckThrowCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // "/qtoggle"
        Player player;
        NamespacedKey namespacedKey = new NamespacedKey((Plugin) this,"isQtoggled");

        if(sender instanceof Player && args[0].length()==0){
        player = (Player) sender;
            PersistentDataContainer data = player.getPersistentDataContainer();
            String str = data.get(namespacedKey, PersistentDataType.STRING);
            boolean isQtoggled = (str==null) ? true : Boolean.parseBoolean(str); // 기본값 true
            //
            if(isQtoggled == true){
                isQtoggled = false;
                data.set(namespacedKey, PersistentDataType.STRING, new Boolean(isQtoggled).toString());
            }
            else{

            }
        }
        return false;
    }
}
