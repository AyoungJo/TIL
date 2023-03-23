public class FullTime extends Employee { // FullTime 은 Employee 이다
	private int salary;
	private int bonus;

	public FullTime() {
	}

	public FullTime(int empNo, String ename, String job, int mgr, String hiredate, String deptName, int salary,
			int bonus) {
		super(empNo, ename, job, mgr, hiredate, deptName); // 부모의 생성자
		this.salary = salary;
		this.bonus = bonus;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public void message() {
		System.out.println(getEname() + "사원은 정규직사원입니다.");

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append(super.toString());

		builder.append(" salary=");
		builder.append(salary);
		builder.append(", bonus=");
		builder.append(bonus);
		builder.append("]");

		return builder.toString();
	}

}
