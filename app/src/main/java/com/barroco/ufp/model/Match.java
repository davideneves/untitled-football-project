package com.barroco.ufp.model;

import java.util.Date;
import java.util.List;

public class Match {

    int id;
    Date date;
    Club teamHome;
    Club teamAway;
    List<Goal> goals;
    List<MatchEvent> events;
}
