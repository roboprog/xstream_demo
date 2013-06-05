
// read or write some data, use XStream library to [de]serialize as needed,
//  using XML encoding.

switch ( args[ 0 ]) {
	case "W" :
			// init some data
			def aMap = [ "a" : 42, "b" : "random" ]
			def anotherMap = [ "a" : 86, "b" : "text" ]

			// make some circular references
			aMap[ "buddy" ] = anotherMap
			anotherMap[ "buddy" ] = aMap

			// get a stack overflow:
			println aMap

			// dump
			println "TODO: write " + aMap
		break
	case "R" :
			println "TODO: read"
		break
	default :
			println "Huh?"
		break
}


