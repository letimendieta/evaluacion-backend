package py.una.fiuna.evaluacion.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Excepciones personalizadas para Evaluacion
 */
public class EvaluacionException extends Exception{

    private static final long serialVersionUID = 1149303182428995606L;

    public HttpStatus status;

    private static HttpStatus localStatus = HttpStatus.BAD_REQUEST;

    public EvaluacionException() {
        super();
    }

    /**
     *
     * @param msg
     */
    public EvaluacionException(String msg){
        super(msg);

        this.status = localStatus;
    }

    /**
     *
     * @param message
     * @param cause
     */
    public EvaluacionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     *
     * @param message
     * @param status
     */
    public EvaluacionException(String message, HttpStatus status) {
        super(message);

        this.status = status;
    }

    /**
     *
     * @param cause
     */
    public EvaluacionException(Throwable cause) {
        super(cause);
    }

    /**
     * Para datos no encontrados
     */
    public static class DataNotFound extends EvaluacionException {

        private static final long serialVersionUID = 114930318242899560L;

        private static HttpStatus localStatus = HttpStatus.NOT_FOUND;

        public DataNotFound(String message) {
            super(message);

            this.status = localStatus;
        }

        public DataNotFound(String message, Throwable cause) {
            super(message, cause);
        }

        public DataNotFound(Throwable cause) {
            super(cause);
        }

        public DataNotFound(String message, HttpStatus status) {
            super(message);

            this.status = status;
        }
    }

    /**
     * Para datos que ya existen
     */
    public static class DataAlreadyExist extends EvaluacionException {

        private static final long serialVersionUID = 11493031824289956L;

        private static HttpStatus localStatus = HttpStatus.BAD_REQUEST;

        public DataAlreadyExist(String message) {
            super(message);

            this.status = localStatus;
        }

        public DataAlreadyExist(String message, Throwable cause) {
            super(message, cause);
        }

        public DataAlreadyExist(Throwable cause) {
            super(cause);
        }

        public DataAlreadyExist(String message, HttpStatus status) {
            super(message);

            this.status = status;
        }
    }

    /**
     * Para errores de regla de negocio
     */
    public static class BusinessException extends EvaluacionException {

        private static final long serialVersionUID = 11493031824289956L;

        private static HttpStatus localStatus = HttpStatus.BAD_REQUEST;

        public BusinessException(String message) {
            super(message);

            this.status = localStatus;
        }

        public BusinessException(String message, Throwable cause) {
            super(message, cause);
        }

        public BusinessException(Throwable cause) {
            super(cause);
        }

        public BusinessException(String message, HttpStatus status) {
            super(message);

            this.status = status;
        }
    }

    /**
     * Para errores de autenticación de usuario y contrasenha
     */
    public static class AuthenticationError extends EvaluacionException {

        private static final long serialVersionUID = 11493031824289956L;

        private static HttpStatus localStatus = HttpStatus.UNAUTHORIZED;

        public AuthenticationError(String message) {
            super(message);

            this.status = localStatus;
        }

        public AuthenticationError(String message, Throwable cause) {
            super(message, cause);
        }

        public AuthenticationError(Throwable cause) {
            super(cause);
        }

        public AuthenticationError(String message, HttpStatus status) {
            super(message);

            this.status = status;
        }
    }

    /**
     * Para errores generales
     */
    public static class InternalServerError extends EvaluacionException {

        private static final long serialVersionUID = 1149303182428995L;

        private static HttpStatus localStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        public InternalServerError(String message) {
            super(message);

            this.status = localStatus;
        }

        public InternalServerError(String message, Throwable cause) {
            super(message, cause);
        }

        public InternalServerError(Throwable cause) {
            super(cause);
        }

        public InternalServerError(String message, HttpStatus status) {
            super(message);

            this.status = status;
        }
    }
}
