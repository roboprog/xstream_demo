
// read or write some data, use XStream library to [de]serialize as needed,
//  using XML encoding.

codec = new com.thoughtworks.xstream.XStream(
		new com.thoughtworks.xstream.io.xml.DomDriver() )

switch ( args[ 0 ]) {
	case "W" :
			// init some data
			def aMap = [ "a" : 42, "b" : "random" ]
			def anotherMap = [ "a" : 86, "b" : "text" ]

			// make some circular references
			aMap[ "buddy" ] = anotherMap
			anotherMap[ "buddy" ] = aMap

			// get a stack overflow:
			// println aMap

			// dump
			println codec.toXML( aMap)
		break
	case "R" :
			// load object back (from stdin)
			def inStr = System.in.text
			def aMap = (Map) codec.fromXML( inStr)

			// clip out the circular references
			def anotherMap = (Map) aMap[ "buddy" ]
			aMap.remove( "buddy")
			anotherMap.remove( "buddy")

			// open the cabinet to show the result of the magic trick:
			println "The maps, (mostly) unharmed: \n\t1) ${aMap}; \n\t2) ${anotherMap}"
		break
	default :
			println "Huh?"
		break
}


