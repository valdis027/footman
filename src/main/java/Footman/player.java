package Footman;

public class player {
        private int id_player;

        private String surname;
        private int id_club;
        private int id_country;

        public int get_id_player() {
            return id_player;
        }

        public void set_id_player(int id_player) {
            this.id_player = id_player;
        }

        public String get_surname() {
            return surname;
        }

        public void set_surname(String surname) {
            this.surname = surname;
        }

        public int get_id_club() {
            return id_club;
        }

        public void set_id_club(int id_club) {
            this.id_club = id_club;
        }

        public int get_id_country() {
            return id_country;
        }

        public void set_id_country(int id_country) {
            this.id_country = id_country;
        }
}
