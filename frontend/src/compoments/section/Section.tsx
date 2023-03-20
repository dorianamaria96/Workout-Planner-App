interface SectionProps {
    container: JSX.Element
  };


export default function Section(props: SectionProps) {
    return (
        <div style={{ display: 'block', padding: '60px' }}>
            {props.container}
        </div>
    );
}