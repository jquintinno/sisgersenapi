package br.com.quintinno.sisgersenapi.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

    public static final String FORMAT0001 = "dd/MM/yyyy HH:mm:ss";

    public static String gerarDataFormatada(String formato) {
        return new SimpleDateFormat(formato).format(new Date());
    }

}
