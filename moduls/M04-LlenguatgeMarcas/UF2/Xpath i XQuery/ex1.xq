for $atraccio in 
doc("parc.xml")/parc/atraccions/zona/atraccio
where $atraccio/edatMinima[@adult='no'] <= 10
return concat("Nom atracció: ", $atraccio/@nom)
