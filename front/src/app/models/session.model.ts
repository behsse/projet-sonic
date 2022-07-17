export default interface Session{
  id : number;
  nom : string;
  dateDebut: string;
  dateFin: string;
  typeSession: string;
  sessionValide: boolean;
  lieuSession: string;
}
