export default interface Session{
  id : Number;
  nom : String;
  debut_session: Date;
  fin_session: Date;
  type_session: String;
  session_valide: Boolean;
}
