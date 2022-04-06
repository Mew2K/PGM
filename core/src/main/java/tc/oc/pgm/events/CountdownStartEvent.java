package tc.oc.pgm.events;

import org.bukkit.event.HandlerList;
import tc.oc.pgm.api.countdowns.Countdown;
import tc.oc.pgm.api.match.Match;
import tc.oc.pgm.api.match.event.MatchEvent;

public class CountdownStartEvent extends MatchEvent {

  private final Countdown countdown;

  private static final HandlerList handlers = new HandlerList();

  public CountdownStartEvent(Match match, Countdown countdown) {
    super(match);
    this.countdown = countdown;
  }

  public Countdown getCountdown() {
    return countdown;
  }

  public static HandlerList getHandlerList() {
    return handlers;
  }

  @Override
  public HandlerList getHandlers() {
    return handlers;
  }
}
