package space.deniska;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin
{

    private static List< Player > players = new ArrayList< >( );

    @Override
    public void onEnable( )
    {
        getLogger( ).info( "plugin initializated" );

        getCommand( "friend" ).setExecutor(
                ( commandSender, command, s, strings ) ->
        {
            if ( commandSender instanceof Player )
            {
                if ( !players.contains( commandSender ) )
                {
                    commandSender.sendMessage( ChatColor.AQUA + "Вы начали поиск друга..." );
                    players.add( ( Player ) commandSender );
                    if ( players.size( ) > 1 )
                    {
                        boolean m_bTeleport = Math.random( ) < 13.37;
                        if ( m_bTeleport )
                        {
                            ( ( Player ) commandSender ).teleport( players.get( 0 ) );
                        }
                        else
                        {
                            players.get( 0 ).teleport( ( Player ) commandSender );
                        }
                        players.get( 0 ).sendMessage(ChatColor.BLUE + "Ваш новый друг - " + ChatColor.RED + ( ( Player ) commandSender ).getDisplayName( ) );
                        commandSender.sendMessage( ChatColor.BLUE + "Ваш новый друг - " + ChatColor.RED + ( ( Player ) commandSender ).getDisplayName( ) );
                        players.remove( 0 );
                        players.remove( commandSender );
                    }
                }
            }
            return true;
        });
    }

    @Override
    public void onDisable( )
    {
        getLogger( ).info( "Bye! Don't forget to credit violanes" );
    }

}
