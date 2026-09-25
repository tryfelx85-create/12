package com.arena.spawn;

import java.util.ArrayList;
import java.util.List;

/** Manually maintained fight queue: each entry is a pair of nicknames (players may not be online yet). */
public class TournamentManager {

    private static final List<String[]> queue = new ArrayList<>();

    public static void add(String a, String b) {
        queue.add(new String[]{a, b});
    }

    /** Inserts a pair at a 1-based position (clamped to the queue size). */
    public static void insert(int position, String a, String b) {
        int index = Math.max(0, Math.min(position - 1, queue.size()));
        queue.add(index, new String[]{a, b});
    }

    /** Removes the fight at a 1-based position; returns it, or null if the position is invalid. */
    public static String[] remove(int position) {
        if (position < 1 || position > queue.size()) return null;
        return queue.remove(position - 1);
    }

    public static void clear() {
        queue.clear();
    }

    public static List<String[]> list() {
        return new ArrayList<>(queue);
    }

    public static String[] peek() {
        return queue.isEmpty() ? null : queue.get(0);
    }

    public static void removeFirst() {
        if (!queue.isEmpty()) queue.remove(0);
    }

    /** True if this nickname is already in some queued fight. */
    public static boolean contains(String name) {
        for (String[] pair : queue) {
            if (pair[0].equalsIgnoreCase(name) || pair[1].equalsIgnoreCase(name)) return true;
        }
        return false;
    }
}
