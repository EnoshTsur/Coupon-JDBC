package enums;
/*****
 * 
 * This is an example of enum implements interface
 * you should not do this with your coupon types!!!!!!!!
 * @author jbt
 *
 */
public enum CouponType implements AnotherInter {

	FOOD("Food") {

		@Override
		public void sayMyName() {
			System.out.println(this.name());

		}
	},
	SPORT("Sport") {

		@Override
		public void sayMyName() {
			System.out.println(this.name());

		}
	};

	protected String name;

	CouponType(String name) {
		this.name = name;
	}

}
