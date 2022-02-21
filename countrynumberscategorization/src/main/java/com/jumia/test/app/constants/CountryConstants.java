package com.jumia.test.app.constants;

import com.jumia.test.app.validator.*;

import java.util.HashMap;
import java.util.Map;

public class CountryConstants {

    public static final class CAMEROON{
        public static final String countryName = "Cameroon";
        public static final String countryCode = "237";
    }

    public static final class ETHIOPIA{
        public static final String countryName = "Ethiopia";
        public static final String countryCode = "251";
    }

    public static final class MOROCCO{
        public static final String countryName = "Morocco";
        public static final String countryCode = "212";
    }

    public static final class MOZAMBIQUE{
        public static final String countryName = "Mozambique";
        public static final String countryCode = "258";
    }

    public static final class UGANDA{
        public static final String countryName = "Uganda";
        public static final String countryCode = "256";
    }

    public static Map<String, PhoneNumberValidator> getCountriesValidatorsMap() {
        HashMap<String, PhoneNumberValidator> countriesValidatorsMap= new HashMap<>();
        countriesValidatorsMap.put(CAMEROON.countryCode,new CameroonPhoneNumberValidator());
        countriesValidatorsMap.put(ETHIOPIA.countryCode,new EthiopiaPhoneNumberValidator());
        countriesValidatorsMap.put(MOROCCO.countryCode,new MoroccoPhoneNumberValidator());
        countriesValidatorsMap.put(MOZAMBIQUE.countryCode,new MozambiquePhoneNumberValidator());
        countriesValidatorsMap.put(UGANDA.countryCode,new UgandaPhoneNumberValidator());
        return countriesValidatorsMap;
    }

    public static Map<String, String> getCountryNamesMap() {
        HashMap<String, String> countryNamesMap= new HashMap<>();
        countryNamesMap.put(CAMEROON.countryCode,CAMEROON.countryName);
        countryNamesMap.put(ETHIOPIA.countryCode,ETHIOPIA.countryName);
        countryNamesMap.put(MOROCCO.countryCode,MOROCCO.countryName);
        countryNamesMap.put(MOZAMBIQUE.countryCode,MOZAMBIQUE.countryName);
        countryNamesMap.put(UGANDA.countryCode,UGANDA.countryName);
        return countryNamesMap;
    }
}
