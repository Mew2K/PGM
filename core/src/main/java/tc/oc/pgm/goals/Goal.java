package tc.oc.pgm.goals;

import javax.annotation.Nullable;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import tc.oc.pgm.api.feature.Feature;
import tc.oc.pgm.api.match.Match;
import tc.oc.pgm.api.party.Competitor;
import tc.oc.pgm.api.party.Party;

/** TODO: Extract CompletableGoal which flags and CPs don't implement */
public interface Goal<T extends GoalDefinition> extends Feature<T> {

  /** @return the {@link Match} this goal is part of */
  Match getMatch();

  /** Test if the given team is allowed to complete this goal. */
  boolean canComplete(Competitor team);

  /** Test if this goal is completed by any team */
  boolean isCompleted();

  /**
   * Test if this goal is completed for the given team. If the goal's completion state is not
   * team-specific (e.g. a destroyable) then this will return true for any team that is allowed to
   * complete the goal, if it is complete.
   */
  boolean isCompleted(Competitor team);

  /**
   * Returns true if this goal can be completed by multiple teams (e.g. a capture point). Currently,
   * this affects how the goal is displayed on the scoreboard, and how it interacts with {@link
   * tc.oc.pgm.filters.GoalFilter}.
   */
  boolean isShared();

  /**
   * Returns true if the goal has the provided {@link tc.oc.pgm.goals.ShowOption}. Objective options
   * define the goal behavior, making it visible only via certain mediums such as the scoreboard and
   * chat.
   */
  boolean hasShowOption(ShowOption option);

  boolean isRequired();

  /**
   * The name of the goal, as displayed to players on scoreboards and such. Usually delegates to
   * {@link GoalDefinition#getName()} but it's possible to implement a goal that can be renamed.
   */
  String getName();

  String getColoredName();

  Component getComponentName();

  /** A color used for fireworks displays */
  Color getColor();

  DyeColor getDyeColor();

  Sound getCompletionSound(boolean positive);

  ChatColor renderSidebarStatusColor(@Nullable Competitor competitor, Party viewer);

  String renderSidebarStatusText(@Nullable Competitor competitor, Party viewer);

  ChatColor renderSidebarLabelColor(@Nullable Competitor competitor, Party viewer);

  Component renderSidebarLabelText(@Nullable Competitor competitor, Party viewer);
}
