import * as React from 'react';
import CssBaseline from '@mui/material/CssBaseline';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import Link from '@mui/material/Link';

function Copyright() {
  return (
    <Typography variant="body2" color='#ffff'>
      {'Copyright © '}
      <Link color="inherit" href="https://mui.com/">
        Just Doriana
      </Link>{' '}
      {new Date().getFullYear()}
      {'.'}
    </Typography>
  );
}

export default function StickyFooter() {
  return (
    <Box
      sx={{
        display: 'flex',
        flexDirection: 'column',
        minHeight: '100vh',
      }}
    >

      <CssBaseline />
      
      <Box
        component="footer"
        sx={{
          py: 3,
          px: 2,
          mt: 'auto',
          textAlign: 'center',
          backgroundColor: '#180516', // update to your desired color code
        }}
      >
        <Container maxWidth="sm">
          <Typography sx={{color: '#ffff'}} variant="body1">
            Excuses don't burn calories.
          </Typography>
          <Copyright />
        </Container>
      </Box>
    </Box>
  );
}