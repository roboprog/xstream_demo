
// read or write some data, use XStream library to [de]serialize as needed,
//  using XML encoding.

codec = new com.thoughtworks.xstream.XStream(
		new com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver() )

switch ( args[ 0 ]) {
	case "W" :
			// init some data
			def aMap = [ "a" : 42, "b" : "random" ]

			// dump
			println codec.toXML( aMap)
		break
	case "R" :
			// load object back (from stdin)
			def inStr = System.in.text
			def aMap = (Map) codec.fromXML( inStr)

			// open the cabinet to show the result of the magic trick:
			println "The map, (mostly) unharmed: ${aMap}"
		break
	default :
			println "Huh?"
		break
}


