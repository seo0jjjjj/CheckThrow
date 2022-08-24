package me.rang.checkthrow.checkthrow;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

/// 이벤트 핸들러
public class CheckThrowListener implements Listener {

    private final CheckThrow pl;

    private final FileConfiguration config;

    private boolean isCancelled = false;

    public CheckThrowListener(CheckThrow pl) { this.pl = pl; this.config = pl.getConfig(); }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player p = event.getPlayer();
        if (config.contains(p.getName()) && config.getBoolean(p.getName())) { // config 에 플레이어의 이름이 포함되어 있고, 콘피그에 저장된 플레이어 이름의 값이 true일 때
            if (!isCancelled) { // 취소된 적이 없을 때
                event.setCancelled(true);
                isCancelled = true;
                p.sendMessage("아이템을 버리려면 다시 한번 아이템을 버리는 키를 누르길 바랍니다.");
            } else {
                isCancelled = false;
            }
        }

    }
}
