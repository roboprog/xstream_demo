
// read or write some data, use XStream library to [de]serialize as needed,
//  using XML encoding.

codec = new com.thoughtworks.xstream.XStream(
		new com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver() )

switch ( args[ 0 ]) {
	case "W" :
			// init some data
			def bean = new ABeanWithAnUnreasonablyLongName(
					"E006", "Joe Blow", 80000)

			// dump
			println codec.toXML( bean)
		break
	case "R" :
			// load object back (from stdin)
			def inStr = System.in.text
			def bean = (ABeanWithAnUnreasonablyLongName) codec.fromXML( inStr)

			// open the cabinet to show the result of the magic trick:
			println "The bean, unharmed: ${ bean }"
		break
	default :
			println "Huh?"
		break
}

/** (immutable) sample bean */
class ABeanWithAnUnreasonablyLongName {

	/** employee ID */
	final String empId

	/** employee name */
	final String name

	/** base salary */
	final BigDecimal salary

	/** init instance */
	public ABeanWithAnUnreasonablyLongName(
			String empId,
			String name,
			BigDecimal salary) {
		this.empId = empId
		this.name = name
		this.salary = salary
	}

	/** debug dump */
	public String toString() {
		return "${ empId } - ${ name }: ${ salary }"
	}
}

