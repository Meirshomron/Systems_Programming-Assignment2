package bgu.spl.a2.sim.tools;

import bgu.spl.a2.sim.Product;

public class NextPrimeHammer implements Tool {
	/**
	 * @return tool name as string
	 */
	public String getType() {
		return "np-hammer";
	}

	/**
	 * Tool use method
	 * 
	 * @param p
	 *            - Product to use tool on
	 * @return a long describing the result of tool use on Product package
	 */
	public  long useOn(Product p) {
		long value = 0;
		for (int i = 0; i < p.getParts().size(); i++) {
			value += func(p.getParts().get(i).getFinalId());
		}

		return value;
	}

    public long func(long id) {
    	
        long v =id + 1;
        while (!isPrime(v)) {
            v++;
        }

        return v;
    }
    private boolean isPrime(long value) {
        if(value < 2) return false;
    	if(value == 2) return true;
        long sq = (long) Math.sqrt(value);
        for (long i = 2; i <= sq; i++) {
            if (value % i == 0) {
                return false;
            }
        }

        return true;
    }

}
