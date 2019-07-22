import packResponse.Any;
import packResponse.GSONwork;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println();

//        http://api.nbp.pl/api/cenyzlota/2013-01-01/2013-01-31/

        String requestURL = "http://api.nbp.pl/api/cenyzlota/2019-01-01/2019-01-10/?format=json";
        System.out.println(requestURL);

//        String requestURL_1 = "http://api.nbp.pl/api/cenyzlota?format=json";

        GSONwork gsoNwork = new GSONwork();

        List<Any> nbPresponse = gsoNwork.loadURLbyStream(requestURL);
        System.out.println(nbPresponse);

//        NBPresponse nbPresponse_1 = gsoNwork.loadURLbyString(requestURL_1);
//        System.out.println(nbPresponse_1);
    }
}
