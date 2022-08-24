package me.rang.checkthrow.checkthrow;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

/// 이벤트 핸들러
public class CheckThrowListener implements Listener {

    private final CheckThrow pl;

    private boolean isCancelled = false;
    private ItemStack is = null;

    public CheckThrowListener(CheckThrow pl) {
        this.pl = pl;
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player p = event.getPlayer();
        PersistentDataContainer data = p.getPersistentDataContainer();
        String str = data.get(new NamespacedKey(pl, "isQtoggled"), PersistentDataType.STRING);
        if (str != null && str.equals(String.valueOf(true))) { // config 에 플레이어의 이름이 포함 && 콘피그에 저장된 플레이어 이름의 값이 true 일 때
            if (!event.getItemDrop().getItemStack().equals(is)) { // 취소된 적이 없을 때 && 기존의 아이템과 드랍하려는 아이템이 같을 때
                event.setCancelled(true);
                is = event.getItemDrop().getItemStack();
                p.sendMessage("아이템을 버리려면 다시 한번 아이템을 버리는 키를 누르길 바랍니다.");

            }

        }
    }
}
