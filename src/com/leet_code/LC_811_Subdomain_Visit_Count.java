package com.leet_code;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LC_811_Subdomain_Visit_Count {
    public static void run() {
        out.println(subdomainVisits(
                new String[] { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" }));
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainToCount = new LinkedHashMap<>();
        for (String s : cpdomains) {
            String[] s1 = s.split(" ");
            int count = Integer.valueOf(s1[0]);
            out.println(s1[1]);
            String[] domains = s1[1].split("\\.");
            StringBuilder domainKeyBuilder = new StringBuilder();
            for (int i = domains.length - 1; i > -1; i--) {
                String domain = domains[i];
                if (i != domains.length - 1) {
                    out.println("adding . " + domains.length);
                    domainKeyBuilder.insert(0, '.');
                }
                domainKeyBuilder.insert(0, domain);
                final String domainKey = domainKeyBuilder.toString();
                final int updatedCount = domainToCount.getOrDefault(domainKey, 0) + count;
                domainToCount.put(domainKey, updatedCount);
            }
        }

        List<String> results = new ArrayList<>();
        for (Entry<String, Integer> entry : domainToCount.entrySet()) {
            results.add(entry.getValue() + " " + entry.getKey());
            //out.println("k:" + entry.getKey() + "| v:" + entry.getValue());
        }
        return results;
    }
}
