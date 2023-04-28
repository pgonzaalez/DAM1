for $atraccio in 
doc("parc.xml")/parc/atraccions/zona/atraccio
where $atraccio/edatMinima[@adult='no'] > 12 and $atraccio/intensitat='Forta'
return concat("Nom atracció: ", $atraccio/@nom)
