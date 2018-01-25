package dk.thegeorge.nav.navcalc

import android.util.Log

/**
 * Created by cdg on 1/24/18.
 */
    val kompas=arrayOf(
            "Nord", "N", "0°", "0 gon"
            ,"Nord til øst", "N. t. Ø.", "11,25°", "12,5 gon"
            ,"Nordnordøst", "NNØ", "22,5°", "25 gon"
            ,"Nordøst til nord", "NØ. t. N.", "33,75°n", "37,5 gon"
            ,"Nordøst", "NØ", "45°", "50 gon"
            ,"Nordøst til øst", "NØ. t. Ø.", "56,25°", "62,5 gon"
            ,"Østnordøst", "ØNØ", "67,5°", "75 gon"
            ,"Øst til nord", "Ø. t. N.", "78,75°", "87,5 gon"
            ,"Øst", "Ø", "90°", "100 gon"
            ,"Øst til syd", "Ø. t. S.", "101,25°", "112,5 gon"
            ,"Østsydøst", "ØSØ", "112,5°", "125 gon"
            ,"Sydøst til øst", "SØ. t. Ø.", "123,75°", "137,5 gon"
            ,"Sydøst", "SØ", "135°", "150 gon"
            ,"Sydøst til syd", "SØ. t. S.", "146,25°", "162,5 gon"
            ,"Sydsydøst", "SSØ", "157,5°", "175 gon"
            ,"Syd til øst", "S. t. Ø.", "168,75°", "187,5 gon"
            ,"Syd", "S", "180°", "200 gon"
            ,"Syd til vest", "S. t. V.", "191,25°", "212,5 gon"
            ,"Sydsydvest", "SSV", "202,5°", "225 gon"
            ,"Sydvest til syd", "SV. t. S.", "213,75°", "237,5 gon"
            ,"Sydvest", "SV", "225°", "250 gon"
            ,"Sydvest til vest", "SV. t. V.", "236,25°", "262,5 gon"
            ,"Vestsydvest", "VSV", "247,5°", "275 gon"
            ,"Vest til syd", "V. t. S.", "258,75°", "287,5 gon"
            ,"Vest", "V", "270°", "300 gon"
            ,"Vest til nord", "V. t. N.", "281,25°", "312,5 gon"
            ,"Vestnordvest", "VNV", "292,5°", "325 gon"
            ,"Nordvest til vest", "NV. t. V.", "303,75°", "337,5 gon"
            ,"Nordvest", "NV", "315°", "350 gon"
            ,"Nordvest til nord", "NV. t. N.", "326,25°", "362,5 gon"
            ,"Nordnordvest", "NNV", "337,5°", "375 gon"
            ,"Nord til vest", "N. t. V.", "348,75°", "387,5 gon");
    /*
    ! 1
| [[North]]
| align="center" | N
| align="center" | ''[[Tramontane|Tramontana]]''
| align="right" | 354.38°
| align="right" | 0.00°
| align="right" | 5.62°
|-
! 2
| North by east
| align="center" | NbE
| align="center" | ''Quarto di Tramontana verso Greco''
| align="right" | 5.63°
| align="right" | 11.25°
| align="right" | 16.87°
|-
! 3
| North-northeast
| align="center" | NNE
| align="center" | ''Greco-Tramontana''
| align="right" | 16.88°
| align="right" | 22.50°
| align="right" | 28.12°
|-
! 4
| Northeast by north
| align="center" | NEbN
| align="center" | ''Quarto di Greco verso Tramontana''
| align="right" | 28.13°
| align="right" | 33.75°
| align="right" | 39.37°
|-
! 5
| Northeast
| align="center" | NE
| align="center" | ''[[Gregale|Greco]]''
| align="right" | 39.38°
| align="right" | 45.00°
| align="right" | 50.62°
|-
! 6
| Northeast by east
| align="center" | NEbE
| align="center" | ''Quarto di Greco verso Levante''
| align="right" | 50.63°
| align="right" | 56.25°
| align="right" | 61.87°
|-
! 7
| East-northeast
| align="center" | ENE
| align="center" | ''Greco-Levante''
| align="right" | 61.88°
| align="right" | 67.50°
| align="right" | 73.12°
|-
! 8
| East by north
| align="center" | EbN
| align="center" | ''Quarto di Levante verso Greco''
| align="right" | 73.13°
| align="right" | 78.75°
| align="right" | 84.37°
|-
! 9
| [[East]]
| align="center" | E
| align="center" | ''[[Levant (wind)|Levante]]''
| align="right" | 84.38°
| align="right" | 90.00°
| align="right" | 95.62°
|-
! 10
| East by south
| align="center" | EbS
| align="center" | ''Quarto di Levante verso Scirocco''
| align="right" | 95.63°
| align="right" | 101.25°
| align="right" | 106.87°
|-
! 11
| East-southeast
| align="center" | ESE
| align="center" | ''Levante-Scirocco''
| align="right" | 106.88°
| align="right" | 112.50°
| align="right" | 118.12°
|-
! 12
| Southeast by east
| align="center" | SEbE
| align="center" | ''Quarto di Scirocco verso Levante''
| align="right" | 118.13°
| align="right" | 123.75°
| align="right" | 129.37°
|-
! 13
| Southeast
| align="center" | SE
| align="center" | ''[[Sirocco|Scirocco]]''
| align="right" | 129.38°
| align="right" | 135.00°
| align="right" | 140.62°
|-
! 14
| Southeast by south
| align="center" | SEbS
| align="center" | ''Quarto di Scirocco verso Ostro''
| align="right" | 140.63°
| align="right" | 146.25°
| align="right" | 151.87°
|-
! 15
| South-southeast
| align="center" | SSE
| align="center" | ''Ostro-Scirocco''
| align="right" | 151.88°
| align="right" | 157.50°
| align="right" | 163.12°
|-
! 16
| South by east
| align="center" | SbE
| align="center" | ''Quarto di Ostro verso Scirocco''
| align="right" | 163.13°
| align="right" | 168.75°
| align="right" | 174.37°
|-
! 17
| [[South]]
| align="center" | S
| align="center" | ''[[Ostro]]''
| align="right" | 174.38°
| align="right" | 180.00°
| align="right" | 185.62°
|-
! 18
| South by west
| align="center" | SbW
| align="center" | ''Quarto di Ostro verso Libeccio''
| align="right" | 185.63°
| align="right" | 191.25°
| align="right" | 196.87°
|-
! 19
| South-southwest
| align="center" | SSW
| align="center" | ''Ostro-Libeccio''
| align="right" | 196.88°
| align="right" | 202.50°
| align="right" | 208.12°
|-
! 20
| Southwest by south
| align="center" | SWbS
| align="center" | ''Quarto di Libeccio verso Ostro''
| align="right" | 208.13°
| align="right" | 213.75°
| align="right" | 219.37°
|-
! 21
| Southwest
| align="center" | SW
| align="center" | ''[[Libeccio]]''
| align="right" | 219.38°
| align="right" | 225.00°
| align="right" | 230.62°
|-
! 22
| Southwest by west
| align="center" | SWbW
| align="center" | ''Quarto di Libeccio verso Ponente''
| align="right" | 230.63°
| align="right" | 236.25°
| align="right" | 241.87°
|-
! 23
| West-southwest
| align="center" | WSW
| align="center" | ''Ponente-Libeccio''
| align="right" | 241.88°
| align="right" | 247.50°
| align="right" | 253.12°
|-
! 24
| West by south
| align="center" | WbS
| align="center" | ''Quarto di Ponente verso Libeccio''
| align="right" | 253.13°
| align="right" | 258.75°
| align="right" | 264.37°
|-
! 25
| [[West]]
| align="center" | W
| align="center" | ''[[Ponente]]''
| align="right" | 264.38°
| align="right" | 270.00°
| align="right" | 275.62°
|-
! 26
| West by north
| align="center" | WbN
| align="center" | ''Quarto di Ponente verso Maestro''
| align="right" | 275.63°
| align="right" | 281.25°
| align="right" | 286.87°
|-
! 27
| West-northwest
| align="center" | WNW
| align="center" | ''Maestro-Ponente''
| align="right" | 286.88°
| align="right" | 292.50°
| align="right" | 298.12°
|-
! 28
| Northwest by west
| align="center" | NWbW
| align="center" | ''Quarto di Maestro verso Ponente''
| align="right" | 298.13°
| align="right" | 303.75°
| align="right" | 309.37°
|-
! 29
| Northwest
| align="center" | NW
| align="center" | ''[[Mistral (wind)|Maestro]]''
| align="right" | 309.38°
| align="right" | 315.00°
| align="right" | 320.62°
|-
! 30
| Northwest by north
| align="center" | NWbN
| align="center" | ''Quarto di Maestro verso Tramontana''
| align="right" | 320.63°
| align="right" | 326.25°
| align="right" | 331.87°
|-
! 31
| North-northwest
| align="center" | NNW
| align="center" | ''Maestro-Tramontana''
| align="right" | 331.88°
| align="right" | 337.50°
| align="right" | 343.12°
|-
! 32
| North by west
| align="center" | NbW
| align="center" | ''Quarto di Tramontana verso Maestro''
| align="right" | 343.13°
| align="right" | 348.75°
| align="right" | 354.37°
|}
     */

/*fun String?.equals(
        other: String?,
        ignoreCase: Boolean = false
): Boolean (source)
*/
public fun Array<String>.indexOfIgnoreCase(element: String?): Int {
    if (element == null) {
        for (index in indices) {
            return index
        }
    } else {
        for (index in indices) {
            if (element.equals(this[index], true)) {
                return index
            }
        }
    }
    return -1
}

fun kompasToDeg(str: String) : Double? {
    try  {
        return str.toDouble();
    } catch (e:NumberFormatException) {
        val idx=kompas.indexOfIgnoreCase(str);
        if(idx>=0) {
            val cardinalPoint=idx/4 as Int;
            return cardinalPoint*11.25;
        }
    }
    return null;
}

fun cleanDeg0_360(degree: Double) : Double {
    var deg= degree
    while(deg<0) {
        deg+=360.0;
    }
    if(deg>=360.0) {
        deg=deg%360;
    }
    return deg;
}

fun cleanDegPm180(degree: Double) : Double {
    var deg=cleanDeg0_360(degree);
    if(deg>180) {
        deg-=360;
    }
    return deg;
}

fun calcAfdrift(text: String, defaultDirectionFrom: Boolean, styretKurs: Double?) : Double? {
    if(styretKurs==null) {
        return null
    }
    val rex = Regex("^\\s*([-0-9.]+)[*:]?\\s*(gående|fra|mod|imod|)\\s*(.*)$");
    val res = rex.matchEntire(text) ?: return null;
    val g = res.groupValues;
        //Log.d(TAG,"g:"+g);
    var afdrift = g[1].toDoubleOrNull() ?: return null;
    var deg = kompasToDeg(g[3]) ?: return null;
    val direction = g[2];
    var directionFrom=false;
    if(direction.isBlank()) {
        directionFrom=defaultDirectionFrom;
    } else if(direction=="gående"){
        directionFrom=false;
    } else if(direction=="fra"){
        directionFrom=true;
    } else if(direction=="mod"){
        directionFrom=false;
    } else if(direction=="imod"){
        directionFrom=false;
    }
    if(directionFrom) {
        deg+=180.0;
    }
    val delta= cleanDeg0_360(deg-styretKurs);
    if(delta>180.0) {
        afdrift=afdrift*-1;
    }
    Log.d(MainActivity.PlaceholderFragment.TAG, "afdrift $afdrift direction: $direction deg:$deg delta:$delta")
    return afdrift;
}