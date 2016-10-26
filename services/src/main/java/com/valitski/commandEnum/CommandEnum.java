package com.valitski.commandEnum;

import com.valitski.command.*;

/**
 * Enum of command
 */
public enum CommandEnum {
    COMMANDLOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    COMMANDONE {
        {
            this.command = new CreateAbiturCommand();
        }
    },
    COMMANDTWO {
        {
            this.command = new CreateStatementCommand();
        }
    },
    COMMANDCHECK {
        {
            this.command = new CheckAbiturCommand();
        }
    },
    COMMANDGET {
        {
            this.command = new GetListAdminCommand();
        }
    },
    COMMANDAPPROVE {
        {
            this.command = new ApproveCommand();
        }
    },
    COMMANDSIGNUP {
        {
            this.command = new SignUpCommand();
        }
    },
    COMMANDLANGUAGE {
        {
            this.command = new LanguageCommand();
        }
    },
    COMMANDRETURN {
        {
            this.command = new ReturnCommand();
        }
    };
    ActionCommand command;

    /**
     * Method getting command from enum
     */
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
