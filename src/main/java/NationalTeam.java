public class NationalTeam {

    public static int[] merge(int[] team, int[] regional_teams) {
        int[] national_team = new int[10];
        int i_team = 0;
        int i_regional_teams = 0;
        int i_national_team = 0;

        while (i_team < team.length || i_regional_teams < regional_teams.length) {
            if (i_national_team == 10) break;
            if (i_team == team.length) {
                national_team[i_national_team] = regional_teams[i_regional_teams];
                i_regional_teams += 1;
            } else if (i_regional_teams == regional_teams.length) {
                national_team[i_national_team] = team[i_team];
                i_team += 1;
            } else if (team[i_team] >= regional_teams[i_regional_teams]) {
                national_team[i_national_team] = team[i_team];
                i_team += 1;
            } else {
                national_team[i_national_team] = regional_teams[i_regional_teams];
                i_regional_teams += 1;
            }
            i_national_team += 1;
        }
        return national_team;
    }

    public static int[] national_team(int[][] regional_teams) {
        int[] team = regional_teams[0];
        for (int i = 1; i < regional_teams.length; i++) {
            team = merge(team, regional_teams[i]);
        }
        return team;
    }
}
