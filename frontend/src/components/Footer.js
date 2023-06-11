import Typography from "@mui/material/Typography";
import Link from "@mui/material/Link";

const Copyright = () => {
    return (
        <Typography variant="body2" color="text.secondary" align="center" >
            {'Copyright © BBM473 Library System'}
            <Link color="inherit" href="https://mui.com/">
            </Link>{' '}
            {new Date().getFullYear()}
            {'.'}
        </Typography>
    );
}

export default Copyright;