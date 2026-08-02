class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) { //entrySet referer til heile key value paret som gjør at du kan bruk getValue() og getKey().
            arr.add(new int[]{entry.getValue(), entry.getKey()}); //Value=frekvens først fordi vi har lyst å sortere arrayet etter frekvens seinare.
        }
        arr.sort((a, b) -> b[0] - a[0]); //Sorterer etter key med størst frekvens først. Altså synkande.

        int[] res = new int[k]; //Resultat array
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }
}

//getOrDefault(n, 0) seier: "gi meg noverande teljar for n, eller 0 om han ikkje finst enno." Så legg vi til 1 og lagrar tilbake. Resultat: {1:1, 2:2, 3:3} for [1,2,2,3,3,3].
