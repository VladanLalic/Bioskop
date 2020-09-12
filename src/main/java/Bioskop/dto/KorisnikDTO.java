package Bioskop.dto;

import sun.util.calendar.BaseCalendar;

import javax.validation.constraints.Email;

public class KorisnikDTO {
    public Long id;
    public String korIme;
    public String lozinka;
    public String ime;
    public String prezime;
    public Long brTel;
    public Email mail;
    public BaseCalendar.Date datumrodj;
    public String uloga;
}
