<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <!--
    Juan Francisco Flores Fernandez
    Ferran Moyano Fernandez
    Pol Gonzalez Miranda
    -->

    <xsl:template match="/">
        <html>
            <head>
                <title>
                    <xsl:value-of select="/parc/@nom"/>
                </title>
                <meta charset="UTF-8"/>
                <link rel="stylesheet" type="text/css" href="horariParc.css"/>
            </head>
            <body>
                <header class="capcalera">
                <!-- Aqui definim el logo del copernic -->
                    <xsl:element name="img">
                        <xsl:attribute name="src">
                            <xsl:value-of select="/parc/@logo"/>
                        </xsl:attribute>
                        <xsl:attribute name="height">
                        48
                        </xsl:attribute>
                    </xsl:element>
                    <!-- El següent span defineix el nom del parc -->
                    <span class="nom">
                        <xsl:value-of select="/parc/@nom"/>
                    </span>
                <!-- Aquest apartat mostra les dades d'obertura y de tancament del parc -->
                </header>
                <header class="dades">
                Obrim del <xsl:value-of select="/parc/dates/dataObertura"/>
                al <xsl:value-of select="/parc/dates/dataTancament"/>
            </header>
            <!-- Seguidament mostrem el nom del mes el cual volem mostrar -->
            <header class="mes">
                <xsl:value-of select="/parc/horaris/mes[@nom='Novembre']/@nom"/>
            </header>

            <!-- La següent taula mostra tota la informació dels dies amb els seus horaris -->
            <table>
                <tr>
                    <xsl:for-each select="/parc/horaris/mes[@nom='Juliol']/periode/diaSetmana">
                        <th>
                            <xsl:value-of select="."/>
                        </th>
                    </xsl:for-each>
                </tr>
                <xsl:for-each select="/parc/horaris/mes[@nom='Novembre']/periode">
                    <tr>
                        <xsl:for-each select="diaSetmana">
                            <td>
                                <div class="dia">
                                    <xsl:value-of select="@diaMes"/>
                                </div>
                                <xsl:choose>
                                    <xsl:when test="@horaObertura">

                                        <xsl:value-of select="@horaObertura"/>
 -                                        <xsl:value-of select="@horaTancament"/>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <xsl:if test="@diaMes">
                                            <div>TANCAT</div>
                                        </xsl:if>
                                    </xsl:otherwise>
                                </xsl:choose>
                            </td>
                        </xsl:for-each>
                    </tr>
                </xsl:for-each>
            </table>
            <!-- La ultima part mostra les dades del parc, com l'adreça , la ciutat o la pagina web -->
            <footer class="dades">
                <xsl:value-of select="/parc/adreca"/>
            </footer>
            <footer class="dades">
                <xsl:value-of select="/parc/ciutat"/>
 -                <xsl:value-of select="/parc/pais"/>
            </footer>
            <footer class="dades">
            web: 
                <xsl:element name="a">
                    <xsl:attribute name="href">
                        <xsl:value-of select="/parc/paginaWeb"/>
                    </xsl:attribute>
                    <xsl:value-of select="/parc/paginaWeb"/>
                </xsl:element>
            </footer>
        </body>
    </html>
</xsl:template>
</xsl:stylesheet>   