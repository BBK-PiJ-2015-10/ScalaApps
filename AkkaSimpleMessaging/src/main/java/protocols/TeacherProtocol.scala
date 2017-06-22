package protocols

object TeacherProtocol {
  
  case class QuoteRequest()
  
  case class QuoteResponse(quoteString: String)
  
}