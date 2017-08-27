class BankAccount {

  private var balance = 0

  def deposit(amount: Int): Unit = {
    if (amount > 0) {
      balance = balance + amount
    }
  }

  def withdraw(amount: Int): Unit = {
    if (amount > 0 && amount <= balance) {
      balance = balance - amount
    } else {
      throw new Error("No funds...")
    }
  }

  override def toString = s"BankAccount($balance)"

}
