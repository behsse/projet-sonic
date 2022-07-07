import Formation from "./formation.model";

export default interface Theme {
  id: number;
  titre: string;
  estSousTheme: boolean;
  themeParent: number;
  sousThemeListe: Theme[];
}
