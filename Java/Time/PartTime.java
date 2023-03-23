public /* abstract */ class PartTime extends Employee {
	private int timePay;

	public PartTime() {
	}

	public PartTime(int empNo, String ename, String job, int mgr, String hiredate, String deptName, int timpePay) {
		super(empNo, ename, job, mgr, hiredate, deptName);
		this.timePay = timpePay;
	}

	public int getTimePay() {
		return timePay;
	}

	public void setTimePay(int timePay) {
		this.timePay = timePay;
	}

	@Override
	public void message() {
		System.out.println(getEname() + "사원은 비정규직사원입니다.");

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());

		builder.append(" timePay = ");
		builder.append(timePay);
		builder.append("]");

		return builder.toString();
	}

}
