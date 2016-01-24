package administration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DAOUtility {

    /*
     * Constructeur caché par défaut (car c'est une classe finale utilitaire,
     * contenant uniquement des méthodes appelées de manière statique)
     */
    private DAOUtility() {
    }

    /* Fermeture silencieuse du resultset */
    public static void silentClosing( ResultSet resultSet ) {
        if ( resultSet != null ) {
            try {
                resultSet.close();
            } catch ( SQLException e ) {
                System.out.println( "Failed closing the ResultSet : " + e.getMessage() );
            }
        }
    }

    /* Fermeture silencieuse du statement */
    public static void silentClosing( Statement statement ) {
        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException e ) {
                System.out.println( "Failed closing the Statement : " + e.getMessage() );
            }
        }
    }

    /* Fermeture silencieuse de la connexion */
    public static void silentClosing( Connection connection ) {
        if ( connection != null ) {
            try {
                connection.close();
            } catch ( SQLException e ) {
                System.out.println( "Failed closing connection : " + e.getMessage() );
            }
        }
    }

    /* Fermetures silencieuses du statement et de la connexion */
    public static void silentClosings( Statement statement, Connection connection ) {
        silentClosing( statement );
        silentClosing( connection );
    }

    /* Fermetures silencieuses du resultset, du statement et de la connexion */
    public static void silentClosings( ResultSet resultSet, Statement statement, Connection connection ) {
        silentClosing( resultSet );
        silentClosing( statement );
        silentClosing( connection );
    }

    /*
     * Initialise la requète préparée basée sur la connexion passée en argument,
     * avec la requête SQL et les objets donnés.
     */
    public static PreparedStatement initializePreparedStatement( Connection connection, String sql, boolean returnGeneratedKeys, Object... objets ) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement( sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
        for ( int i = 0; i < objets.length; i++ ) {
            preparedStatement.setObject( i + 1, objets[i] );
        }
        return preparedStatement;
    }
}