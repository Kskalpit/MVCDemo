package mvcdemo.model;

public class Filter {
		private String Field;
		private String operator;
		private String value;
	/*	private String s;
		
		public Filter(String x) {
			this.s = x;
		}*/
		public void setField(String Field) {
			this.Field = Field;
		}
		public String getField() {
			return Field;
		}
		public void setoperator(String operator) {
			this.operator = operator;
		}
		public String getoperator() {
			return operator;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getvalue() {
			return value;
		}
		@Override
		public String toString() {
			return this.Field;
					}
		
		
		
}
